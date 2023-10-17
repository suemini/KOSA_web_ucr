$(() => {
    //수강신청 하기
    function addRegistration() {
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
                $('div.wishlist').hide()
                $('div.addRegistration').show()
                $('div.registrationList').hide()
                const $tbodyObj = $('div.addRegistration>div.searchCourse>table.courseList>tbody');
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
                    if(c.regiCnt < c.coLimit){
                        const tdButtonValue = '<button class="add" type="submit">신청</button>'
                        appendTd('addButton', tdButtonValue)
                    }
                    $tbodyObj.append($copyTrObj); // 새로 생성한 행을 테이블에 추가합니다.
                });
            }
        });
    }

    // 조회 버튼 객체를 클릭했을 때 실행되는 이벤트 핸들러
    const $buttonObj = $('div.addRegistration>div.searchTap>div.buttonset>button.btn-search');
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
                const $tbodyObj = $('div.addRegistration>div.searchCourse>table.courseList>tbody');
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

    wishlist()

    //수강신청에서 수강신청 신청버튼 클릭시 수강신청(addRegistration)
    $('div.searchCourse>table.courseList>tbody').on('click', 'tr>td.addButton>button.add', (e) => {
        const coCode = $(e.target).parent().siblings("td.coCode").html()
        const coDay = $(e.target).parent().siblings("td.coDay").html()
        const coTime = $(e.target).parent().siblings("td.coTime").html()
        // console.log(coCode)
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/addregistration?coCode=' + coCode + '&coDay=' + coDay + '&coTime=' + coTime,
            method: 'get',
            success: (responseJSONObj) => {
                if (responseJSONObj.status == 0) { //신청실패
                    alert(responseJSONObj.msg)
                } else {
                    alert("신청성공")
                    addRegistration()
                }
            }
        })
    })

    //span의 수강신청 버튼 클릭시 수강신청 불러오기
    $('div.indexTap>span.addRegistration').click(() => {
        addRegistration()
    })


    //span의 희망강좌조회버튼 클릭시 희망강좌내역 불러오기
    $('div.indexTap>span.wishlist').click(() => {
        wishlist()
    })


    //희망강좌 조회
    function wishlist() {
        const $trs = $('div.wishlist>div.searchCourse>table>tbody>tr')
        $trs.not(':first').remove()
        //원본 wishlist객체찾기
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
                    //희망과목이 없을 경우 수강신청으로 넘기기
                    addRegistration()
                    return
                }
                $('div.addRegistration').hide()
                $('div.wishlist').show()
                $('div.registrationList').hide()
                // console.log("----------희망강좌 조회 결과-----------------")
                // console.log(responseJSONObj)
                // console.log($originTr.css('display'))
                for (let i = 0; i < responseJSONObj.courses.length; i++) {
                    //복제본 Wishlist객체생성
                    let $copyTr = $originTr.clone()
                    //자료 어펜드
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
                    //복제본객체를 .Regilist객체의 자식으로 추가
                    $originTr.parent().append($copyTr)
                }
                $originTr.hide()

            },
            error: (jqxhr) => {
                // alert(jqxhr.status)
            }
        })
    }

    //희망강좌 조회에서 수강신청버튼 클릭시 수강신청(addWishlist)
    $('div.searchCourse>table.courseList>tbody').on('click', 'tr>td.button>button.add', (e) => {
        const coCode = $(e.target).parent().siblings("td.coCode").html()
        const coDay = $(e.target).parent().siblings("td.coDay").html()
        const coTime = $(e.target).parent().siblings("td.coTime").html()
        // console.log(coCode)
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/addregistration?coCode=' + coCode + '&coDay=' + coDay + '&coTime=' + coTime,
            method: 'get',
            success: (responseJSONObj) => {
                if (responseJSONObj.status == 0) { //신청실패
                    alert(responseJSONObj.msg)
                } else {
                    alert("신청성공")
                    wishlist()
                }
            }
        })
    })

    //span의 수강신청내역 버튼 클릭시 수강신청내역 불러오기
    $('div.indexTap>span.registrationList').click(() => {
        registrationList()
    })


    //수강신청 내역조회
    function registrationList() {
        const $trs = $('div.registrationList>div.searchCourse>table>tbody>tr')
        $trs.not(':first').remove()
        //원본 list_registration객체찾기
        const $originTr = $trs.first()
        $originTr.show()
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/registrationlist',
            method: 'get',
            success: (responseJSONObj) => {
                if (responseJSONObj.status == 0) {
                    alert(responseJSONObj.msg)
                    addRegistration()
                    return
                }
                $('div.wishlist').hide()
                $('div.addRegistration').hide()
                $('div.registrationList').show()
                // console.log(responseJSONObj)
                //현재학점 계산용 변수
                var currentMajorRequired = 0
                var currentMajorBasic = 0
                var currentMajorSelect = 0
                var currentCulture = 0
                for (let i = 0; i < responseJSONObj.courses.length; i++) {
                    //복제본 Regilist객체생성
                    let $copyTr = $originTr.clone()
                    //자료 어펜드
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

                    //복제본객체를 .Regilist객체의 자식으로 추가
                    $('div.registrationList>div.searchCourse>table.courseList>tbody').append($copyTr)

                    //현재 학점 계산만
                    if (division == '전공필수') {
                        currentMajorRequired = currentMajorRequired + coCredit
                    } else if (division == '전공기초') {
                        currentMajorBasic = currentMajorBasic + coCredit
                    } else if (division == '전공선택') {
                        currentMajorSelect = currentMajorSelect + coCredit
                    } else if (division == '교양') {
                        currentCulture = currentCulture + coCredit
                    }
                }
                $originTr.hide()
                $.ajax({
                    xhrFields: {
                        withCredentials: true
                    },
                    url: backURL + '/credits',
                    method: 'get',
                    success: (responseJSONObj) => {
                        // console.log(responseJSONObj)
                        const $originCurr = $('div.registrationList>div.credits>div.currentCredits>table').first()
                        const $originPast = $('div.registrationList>div.credits>div.pastCredits>table').first()
                        const $originTotal = $('div.registrationList>div.credits>div.totalCredits>table').first()
                        const $originRemain = $('div.registrationList>div.credits>div.remainCredits>table').first()
                        
                        //과거학점 계산용 변수
                        var pastMajorRequired = 0 //전필
                        var pastMajorBasic = 0 //전기
                        var pastMajorSelect = 0 //전선
                        var pastCulture = 0 //교양
                        var stackTotal = 0 //토탈
                        if (responseJSONObj.status == 1) { //과거O
                            //과거학점계산
                            pastMajorRequired = responseJSONObj.pastCredits[0].credit
                            pastMajorBasic = responseJSONObj.pastCredits[1].credit
                            pastMajorSelect = responseJSONObj.pastCredits[2].credit
                            pastCulture = responseJSONObj.pastCredits[3].credit
                            stackTotal = pastMajorRequired + pastMajorBasic + pastMajorSelect + pastCulture
                        }
                        
                        //금학기 학점 올리기
                        let thisSemesterTotal = currentCulture + currentMajorBasic + currentMajorRequired + currentMajorSelect
                        $originCurr.find('tr>td.thisSemesterTotal').html(thisSemesterTotal)
                        $originCurr.find('tr>td.currentMajorRequired').html(currentMajorRequired)
                        $originCurr.find('tr>td.currentMajorBasic').html(currentMajorBasic)
                        $originCurr.find('tr>td.currentMajorSelect').html(currentMajorSelect)
                        $originCurr.find('tr>td.currentCulture').html(currentCulture)

                        //과거학점 올리기
                        $originPast.find('tr>td.stackTotal').html(stackTotal)
                        $originPast.find('tr>td.pastMajorRequired').html(pastMajorRequired)
                        $originPast.find('tr>td.pastMajorBasic').html(pastMajorBasic)
                        $originPast.find('tr>td.pastMajorSelect').html(pastMajorSelect)
                        $originPast.find('tr>td.pastCulture').html(pastCulture)

                        //총학점 계산용
                        let totalTotal = stackTotal + thisSemesterTotal
                        let totalMajorRequired = currentMajorRequired + pastMajorRequired
                        let totalMajorBasic = currentMajorBasic + pastMajorBasic
                        let totalMajorSelect = currentMajorSelect + pastMajorSelect
                        let totalCulture = currentCulture + pastCulture
                        //총학점 올리기
                        $originTotal.find('tr>td.totalTotal').html(totalTotal)
                        $originTotal.find('tr>td.totalMajorRequired').html(totalMajorRequired)
                        $originTotal.find('tr>td.totalMajorBasic').html(totalMajorBasic)
                        $originTotal.find('tr>td.totalMajorSelect').html(totalMajorSelect)
                        $originTotal.find('tr>td.totalCulture').html(totalCulture)
                        
                        //졸업요건 계산용
                        let remainTotal = 130
                        let remainMajorRequired = 30
                        let remainMajorBasic = 21
                        let remainMajorSelect = 9
                        let remainCulture = 25
                        if(remainTotal-totalTotal<0){//토탈
                            remainTotal = 0
                        }else{
                            remainTotal = remainTotal - totalTotal
                        }
                        if(remainMajorRequired-totalMajorRequired<0){//전필
                            remainMajorRequired = 0
                        }else{
                            remainMajorRequired = remainMajorRequired - totalMajorRequired
                        }
                        if(remainMajorBasic-totalMajorBasic<0){//전기
                            remainMajorBasic = 0
                        }else{
                            remainMajorBasic = remainMajorBasic - totalMajorBasic
                        }
                        if(remainMajorSelect-totalMajorSelect<0){//전선
                            remainMajorSelect = 0
                        }else{
                            remainMajorSelect = remainMajorSelect - totalMajorSelect
                        }
                        if(remainCulture-totalCulture<0){//교양
                            remainCulture = 0
                        }else{
                            remainCulture = remainCulture - totalCulture
                        }
                        //졸업요건 올리기
                        $originRemain.find('tr>td.remainTotal').html(remainTotal)
                        $originRemain.find('tr>td.remainMajorRequired').html(remainMajorRequired)
                        $originRemain.find('tr>td.remainMajorBasic').html(remainMajorBasic)
                        $originRemain.find('tr>td.remainMajorSelect').html(remainMajorSelect)
                        $originRemain.find('tr>td.remainCulture').html(remainCulture)
                        //반복문이 아니라 바로 값을 넣어주고 append하지 않음
                    }
                })
            },
            error: (jqxhr) => {
                // alert(jqxhr.status)
            }
        })
    }

    //수강신청내역 조회에서 수강신청 취소버튼 클릭시 수강신청 취소(removeregistration)
    $('div.registrationList>div.searchCourse>table.courseList>tbody').on('click', 'tr>td.button>button.remove', (e) => {
        const coCode = $(e.target).parent().siblings("td.coCode").html()
        // console.log(coCode)
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/removeregistration?coCode=' + coCode,
            method: 'get',
            success: (responseJSONObj) => {
                if (responseJSONObj.status == 0) { //취소실패
                    alert(responseJSONObj.msg)
                } else {
                    alert("취소성공")
                    registrationList()
                }
            }
        })
    })


})
