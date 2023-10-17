$(() => {
    const noticeNo = sessionStorage.getItem('noticeNo')
    
    $.ajax({
        url: backURL + '/noticedetail',
        data: `noticeNo=${noticeNo}`,
        success: (responseObj) => {
            const $originNoticeDetail = $('div.noticeWrap>div.noticeView')

            $originNoticeDetail.find('p').html(responseObj.title)
            $originNoticeDetail.find('dd.writeDate').html(responseObj.writeDate)
            $originNoticeDetail.find('dd.viewCount').html(responseObj.viewCount)
            $originNoticeDetail.find('div.cont').html(responseObj.contents)

        },
        error: () => {
        }
    })

    $('div.noticeWrap').on('click', 'button', (e) => {
        const $sectionObj = $('section#mainSection')
        $sectionObj.empty()
        ajaxHandler('GET', `./notice.html`, $sectionObj)
    })
})