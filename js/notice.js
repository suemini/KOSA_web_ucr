function noticeAjaxHandler(cp) {
    $.ajax({
        url: backURL + '/notice',
        method: 'get',
        data: `currentPage=${cp}`,
        success: (responseJSONObj) => {
            const list = responseJSONObj.list

            const $originNotice = $('div.noticeWrap>div.noticeBox>div.functionWrap>div.noticeList').first()
            $originNotice.siblings().remove()
            $originNotice.show()
            $(list).each((index, n) => {
                let $copyNotice = $originNotice.clone()
                let noticeNo = n.noticeNo
                let title = n.title
                let writeDate = n.writeDate.substr(0, 10)
                console.log(n.writeDate)
                let viewCount = n.viewCount

                $copyNotice.find('div.num').html(noticeNo)
                $copyNotice.find('div.title').html(title)
                $copyNotice.find('div.date').html(writeDate)
                $copyNotice.find('div.count').html(viewCount)

                $('div.noticeWrap>div.noticeBox>div.functionWrap').append($copyNotice)
            })
            $originNotice.hide()

            const $divListPaging = $('div.listPaging')
            $divListPaging.empty()
            const startPage = responseJSONObj.startPage
            const endPage = responseJSONObj.endPage
            const totalPage = responseJSONObj.totalPage
            if (startPage > 1) {
                let page = `<button class="pg1"><<</button><button class="pg${(startPage - 1)}"><</button>`
                $divListPaging.html($divListPaging.html() + page)
            }
            for (let i = startPage; i <= endPage; i++) {
                let page = `<button class="pg${i}">${i}</button>`
                $divListPaging.html($divListPaging.html() + page)
            }
            if (endPage != responseJSONObj.totalPage) {
                let page = `<button class="pg${endPage + 1}">></button><button class="pg${totalPage}">>></button>`
                $divListPaging.html($divListPaging.html() + page)
            }

            $divListPaging.find(`button.pg${cp}`).addClass('on')
        },
        error: () => {
        }
    })
}

$(()=>{
    $('div.listPaging').on('click', 'button', (e) => {
        const pg = $(e.target).attr('class')
        const currentPage = pg.substr(2)

        sessionStorage.setItem('currentPage',currentPage)

        console.log(currentPage)
    
        noticeAjaxHandler(currentPage)
    })
    
    $('div.noticeWrap>div.noticeBox>div.functionWrap').on('click', 'div.noticeList', (e) => {
        const clickedElement = $(e.currentTarget)
        const noticeNo = clickedElement.find('div.num').text()
        
        sessionStorage.setItem('noticeNo', noticeNo)
        

        const $sectionObj = $('section#mainSection')
        $sectionObj.empty()
        ajaxHandler('GET', `./notice_detail.html`, $sectionObj)
        // ajaxHandler('GET', `./notice_detail.html?noticeNo=${noticeNo}`, $sectionObj)
        // $sectionObj.load(`./notice_detail.html?noticeNo=${noticeNo}`)
    })

    let currentPage = 1
    let storageCurrentPage = sessionStorage.getItem("currentPage")
    if( storageCurrentPage != null && storageCurrentPage > 1){
        currentPage = storageCurrentPage
    }
    noticeAjaxHandler(currentPage)
 
})


