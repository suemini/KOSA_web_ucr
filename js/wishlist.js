$(() => {
    //희망강좌 담기
    function addwishlist() {
        $('select.mName').css('display', 'none');
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/searchAll',
            method: 'get',
            // data:,
            success: (responseJSONObj) => {
                if (responseJSONObj.length === 0) {
                    alert('강좌가 없습니다!');
                    return;
                }
                $('div.wishlistList').hide()
                $('div.addwishlist').show()
                const $tbodyObj = $('div.addwishlist>div.searchCourse>table.courseList>tbody');
                $tbodyObj.empty(); // 데이터로 채우기 전에 tbody를 비웁니다.

                responseJSONObj.forEach(element => {
                    const c = element; // 강의 정보 객체

                    // 새로운 테이블 행을 생성합니다.
                    const $copyTrObj = $('<tr>');

                    // 조건에 따라 <td> 엘리먼트를 생성하고 추가합니다.
                    function appendTd(className, value) {
                        const $tdObj = $('<td>');
                        $tdObj.addClass(className);
                        $tdObj.html(value || ''); // 값이 없는 경우 빈 문자열로 설정합니다.
                        $copyTrObj.append($tdObj);
                    }
                    appendTd('coCode', c.coCode);
                    appendTd('coName', c.coName);

                    // 'coProName'이 정의되고 null이 아닌지 확인합니다.
                    let proName = '-'; // 기본값
                    if (c.coProName && c.coProName.proName !== null) {
                        proName = c.coProName.proName;
                    }
                    appendTd('proName', proName);

                    appendTd('division', c.division);
                    appendTd('coYear', c.coYear);
                    appendTd('coMajor', c.coMajorName && c.coMajorName.mname);
                    appendTd('coCredit', c.coCredit);
                    appendTd('coLimit', c.coLimit);
                    appendTd('coDay', c.coDay);
                    appendTd('coTime', c.coTime);
                    appendTd('classroom', c.classroom);
                    const tdButtonValue = '<button class="add" type="submit">신청</button>'
                    appendTd('addButton', tdButtonValue)

                    $tbodyObj.append($copyTrObj); // 새로 생성한 행을 테이블에 추가합니다.
                });
            }
        });
    }
    // 조회 버튼 객체를 클릭했을 때 실행되는 이벤트 핸들러
    const $buttonObj = $('div.addwishlist>div.searchTap>div.buttonset>button.btn-search');
    $buttonObj.click(() => {
        // 검색어와 선택한 옵션 값을 가져옵니다.
        const proName = $('#proName').val();
        const coName = $('#coName').val();
        const mName = $('.mName').val();
        const coDay = $('#coDay').val();

        // 서버로 데이터 요청을 보냅니다.
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/searchcourses',
            method: 'get',
            data: {
                proName: proName,
                coName: coName,
                coDay: coDay,
                mName: mName
            },
            success: (responseJSONObj) => {
                const $tbodyObj = $('div.addwishlist>div.searchCourse>table.courseList>tbody');
                $tbodyObj.empty(); // 데이터로 채우기 전에 tbody를 비웁니다.

                if (responseJSONObj.status == 0) {
                    alert(responseJSONObj.msg)
                    return
                }
                const list = responseJSONObj.list
                if (list.length == 0) {
                    alert('강좌가 없습니다!');
                    return;
                }

                list.forEach(element => {
                    const c = element; // 강의 정보 객체

                    // 새로운 테이블 행을 생성합니다.
                    const $copyTrObj = $('<tr>');

                    // 조건에 따라 <td> 엘리먼트를 생성하고 추가합니다.
                    function appendTd(className, value) {
                        const $tdObj = $('<td>');
                        $tdObj.addClass(className);
                        $tdObj.html(value || ''); // 값이 없는 경우 빈 문자열로 설정합니다.
                        $copyTrObj.append($tdObj);
                    }

                    appendTd('coCode', c.coCode);
                    appendTd('coName', c.coName);

                    // 'coProName'이 정의되고 null이 아닌지 확인합니다.
                    let proName = '-'; // 기본값
                    if (c.coProName && c.coProName.proName !== null) {
                        proName = c.coProName.proName;
                    }
                    appendTd('proName', proName);

                    appendTd('division', c.division);
                    appendTd('coYear', c.coYear);
                    appendTd('coMajor', c.coMajorName && c.coMajorName.mname);
                    appendTd('coCredit', c.coCredit);
                    appendTd('coLimit', c.coLimit);
                    appendTd('coDay', c.coDay);
                    appendTd('coTime', c.coTime);
                    appendTd('classroom', c.classroom);

                    const tdButtonValue = '<button class="add" type="submit">신청</button>'
                    appendTd('addButton', tdButtonValue)

                    $tbodyObj.append($copyTrObj); // 새로 생성한 행을 테이블에 추가합니다.
                });
            }
        });
    });

    addwishlist()

    //희망강좌 담기에서 희망강좌 신청버튼 클릭시 희망수강신청(addWishlist)
    $('div.searchCourse>table.courseList>tbody').on('click', 'tr>td.addButton>button.add', (e) => {
        const coCode = $(e.target).parent().siblings("td.coCode").html()
        // console.log(coCode)
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/addwishlist?coCode=' + coCode,
            method: 'get',
            success: (responseJSONObj) => {
                if (responseJSONObj.status == 0) { //신청실패
                    alert("희망강좌 신청 불가능 : 이미 신청한 강좌입니다")
                } else {
                    alert("신청성공")
                    addwishlist()
                }
            }
        })
    })

    //span의 담기버튼 클릭시 희망강좌담기 불러오기
    $('div.indexTap>span.addwishlist').click(()=>{
        addwishlist()
    })

    //희망강좌 조회
    function wishlistList() {
        const $trs = $('div.wishlistList>div.searchCourse > table > tbody > tr')        
        $trs.not(':first').remove()
        //원본 list_wishlist객체찾기
        const $originTr = $trs.first()
        $originTr.show()
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/wishlist',
            method: 'get',
            success: (responseJSONObj) => {
                if (responseJSONObj.status == 0) {
                    alert(responseJSONObj.msg)
                    addwishlist()
                    return
                }
                $('div.addwishlist').hide()
                $('div.wishlistList').show()
                 for (let i = 0; i < responseJSONObj.courses.length; i++) {
                     //복제본 Wishlist객체생성
                     let $copyTr = $originTr.clone()
                     //자료 받기
                     const c = responseJSONObj.courses[i]
                     const m = c.coMajorName
                     const p = c.coProName
 
                     //자료대입
                     let coCode = c.coCode
                     let coName = c.coName
                     let coYear = c.coYear
                     if (c !== null && c.coYear !== 0) { // c 객체와 c.coYear 모두 null이 아닌 경우
                        coYear = c.coYear
                    } else {
                        coYear = ''
                    }
                     let coLimit = c.coLimit
                     let coCredit = c.coCredit
                     let classroom = c.classroom
                     let division = c.division
                     let coDay = c.coDay
                     let coTime = c.coTime
                     let coMajor = m.mName
                     let proName // proName 변수 먼저 선언
                     if (p !== null && p.proName !== null) { // p 객체와 p.proName이 모두 null이 아닌 경우
                         proName = p.proName
                     } else {
                         proName = '-'
                     }


                     // console.log(coCode, coName, coYear, coLimit, coCredit, classroom, division, coDay, coTime, coMajor, proName)
                     $copyTr.find('td.coCode').html(coCode)
                     $copyTr.find('td.coName').html(coName)
                     $copyTr.find('td.coYear').html(coYear)
                     $copyTr.find('td.coLimit').html(coLimit)
                     $copyTr.find('td.coCredit').html(coCredit)
                     $copyTr.find('td.classroom').html(classroom)
                     $copyTr.find('td.division').html(division)
                     $copyTr.find('td.coDay').html(coDay)
                     $copyTr.find('td.coTime').html(coTime)
                     $copyTr.find('td.coMajor').html(coMajor)
                     $copyTr.find('td.proName').html(proName)
                     //복제본객체를 .wishlist객체의 자식으로 추가
                     $originTr.parent().append($copyTr)
 
                 }
                 $originTr.hide()
 
             },
             error: (jqxhr) => {
                //  alert(jqxhr.status)
             }
         })
     }
 
     //희망강좌 조회에서 희망강좌 취소버튼 클릭시 희망수강신청 취소(removeWishlist)
     $('div.searchCourse>table.courseList>tbody').on('click', 'tr>td.button>button.remove',(e) => {
         //$("선택자")
         //$(JS객체)
         const coCode = $(e.target).parent().siblings("td.coCode").html()
        //  console.log(coCode)
         $.ajax({
             xhrFields: {
                 withCredentials: true
             },
             url: backURL + '/removewishlist?coCode=' + coCode,
             method: 'get',
             success: (responseJSONObj) => {
                 if (responseJSONObj.status == 0) { //취소실패
                     alert(responseJSONObj.msg)
                 } else {
                     alert("취소성공")
                     wishlistList()
                 }
             }
         })
     })

    //span의 조회버튼 클릭시 희망강좌조회목록 불러오기
    $('div.indexTap>span.wishlistList').click(()=>{
       wishlistList()
    })

})
