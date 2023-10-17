$(() => {
    function procourse() {
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/professorcourse',
            method: 'get',
            success: (responseJSONObj) => {
                if (responseJSONObj.status == 0) {
                    alert(responseJSONObj.msg)
                    return
                }
                $('div.professorStudent').hide()
                $('div.professorCourse').show()
                //원본 tbody 객체찾기
                const $originTr = $('div.professorCourse>div.searchCourse>table.courseList>tbody>tr').first()
                for (let i = 0; i < responseJSONObj.courses.length; i++) {
                    //복제본 tbody 객체생성
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
                    $('div.professorCourse>div.searchCourse>table.courseList>tbody').append($copyTr)
                }
                $originTr.hide()
            },
            error: (jqxhr) => {
                alert(jqxhr.status)
            }
        })
    }

    procourse()

    //tr 클릭시 학생목록으로 이동
    $('div.professorCourse>div.searchCourse>table.courseList>tbody').on('click', 'tr', (e) => {
        //$("선택자")
        //$(JS객체)
        const coCode = $(e.currentTarget).find("td.coCode").html()
        $.ajax({
            xhrFields: {
                withCredentials: true
            },
            url: backURL + '/studentlist?coCode=' + coCode,
            method: 'get',
            success: (responseJSONObj) => {
                if (responseJSONObj.status == 0) { //조회실패
                    alert(responseJSONObj.msg)
                    return
                }
                $('div.professorCourse').hide()
                $('div.professorStudent').show()
                //원본 학생 객체찾기
                const $originTr = $('div.professorStudent>div.studentList>table>tbody>tr').first()
                for (let i=0; i < responseJSONObj.students.length; i++) {
                    //복제본 학생 객체생성
                    let $copyTr = $originTr.clone()
                    //자료 받기
                    const s = responseJSONObj.students[i]
                    const m = s.coMajorName
                    //자료 대입
                    let stuId = s.stuId
                    let stuName = s.stuName
                    let stuEmail = s.stuEmail
                    let stuPhone = s.stuPhone
                    let stuGrades = s.stuGrades
                    let mName = m.mName
                    let mUni = m.mUni
                    //자료 셋팅
                    $copyTr.find('td.stuId').html(stuId)
                    $copyTr.find('td.stuName').html(stuName)
                    $copyTr.find('td.stuEmail').html(stuEmail)
                    $copyTr.find('td.stuPhone').html(stuPhone)
                    $copyTr.find('td.stuGrades').html(stuGrades)
                    $copyTr.find('td.mName').html(mName)
                    $copyTr.find('td.mUni').html(mUni)
                    //복제본객체를 원본객체의 자식으로 추가
                    $originTr.parent().append($copyTr)
                }
                $originTr.hide()
            }
        })
    })

    //span의 뒤로가기 클릭시 강좌목록 불러오기
    $('div.professorStudent>div.indexTap>span.back').click(() => {
        procourse()
    })

})