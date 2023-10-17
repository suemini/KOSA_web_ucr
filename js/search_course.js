$(() => {
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
            const $tbodyObj = $('section.searchCourse>div.searchCourse>table.courseList>tbody');
            $tbodyObj.empty(); // 데이터로 채우기 전에 tbody를 비웁니다.

            responseJSONObj.forEach(element => {
                const c = element; // 강의 정보 객체

                // 새로운 테이블 행을 생성합니다.
                const $copyTrObj = $('<tr>');

                // 조건에 따라 <td> 엘리먼트를 생성하고 추가합니다.
                function appendTd(className, value) {
                    const $tdObj = $('<td>');
                    $tdObj.addClass(className);
                    $tdObj.text(value || ''); // 값이 없는 경우 빈 문자열로 설정합니다.
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

                $tbodyObj.append($copyTrObj); // 새로 생성한 행을 테이블에 추가합니다.
            });
        }
    });

    // 조회 버튼 객체를 클릭했을 때 실행되는 이벤트 핸들러
    const $buttonObj = $('section.searchCourse>div.searchTap>div.buttonset>button.btn-search');
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
                const $tbodyObj = $('section.searchCourse>div.searchCourse>table.courseList>tbody');
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
                        $tdObj.text(value || ''); // 값이 없는 경우 빈 문자열로 설정합니다.
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

                    $tbodyObj.append($copyTrObj); // 새로 생성한 행을 테이블에 추가합니다.
                });
            }
        });
    });
});
