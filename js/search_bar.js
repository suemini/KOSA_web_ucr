$(() => {
    $('select.mName').css('display', 'none');
    // 선택 요소와 입력 필드의 초기값 설정
    var selectedYear = "2023";
    var selectedSemester = "2학기";
    var selectedMajorUniCategory = "All";
    var selectedMName = "All";
    var selectedCoDay = "All";
    var selectedCoName = "";
    var selectedProName = "";

    // 선택 요소의 초기값 설정
    $('select.choice[name="year"]').val(selectedYear);
    $('select.choice[name="semester"]').val(selectedSemester);
    $('select.majorUniCategory').val(selectedMajorUniCategory);
    $('select.mName').val(selectedMName);
    $('select.choice#coDay').val(selectedCoDay);
    $('input[name="coName"]').val(selectedCoName);
    $('input#proName').val(selectedProName);


    $('#proName').on('focus', () => {
        $('select.choice[name="year"]').val(selectedYear);
        $('select.choice[name="semester"]').val(selectedSemester);
        $('select.majorUniCategory').val(selectedMajorUniCategory);
        $('select.mName').val(selectedMName);
        $('select.mName').css('display', 'none');
        $('select.choice#coDay').val(selectedCoDay);
        $('input[name="coName"]').val(selectedCoName);
    })

    $('#coName').on('focus', () => {
        $('select.choice[name="year"]').val(selectedYear);
        $('select.choice[name="semester"]').val(selectedSemester);
        $('select.majorUniCategory').val(selectedMajorUniCategory);
        $('select.mName').val(selectedMName);
        $('select.mName').css('display', 'none');
        $('select.choice#coDay').val(selectedCoDay);
        $('input#proName').val(selectedProName);
    })
    $('.mName').on('change', () => {
        $('select.choice[name="year"]').val(selectedYear);
        $('select.choice[name="semester"]').val(selectedSemester);
        $('select.choice#coDay').val(selectedCoDay);
        $('input[name="coName"]').val(selectedCoName);
        $('input#proName').val(selectedProName);
    })
    $('#majoruni').on('change', () => {
        $('select.choice[name="year"]').val(selectedYear);
        $('select.choice[name="semester"]').val(selectedSemester);
        $('select.choice#coDay').val(selectedCoDay);
        $('input[name="coName"]').val(selectedCoName);
        $('input#proName').val(selectedProName);
    })

    $('#coDay').on('change', () => {
        $('select.choice[name="year"]').val(selectedYear);
        $('select.choice[name="semester"]').val(selectedSemester);
        $('select.majorUniCategory').val(selectedMajorUniCategory);
        $('select.mName').val(selectedMName);
        $('select.mName').css('display', 'none');
        $('input[name="coName"]').val(selectedCoName);
        $('input#proName').val(selectedProName);
    })
    
    const $selectMajorUniObj = $('select.majorUniCategory');
    // ---- select 객체에서 클릭 이벤트가 발생했을 때 할 일 END ----
    // DOM 트리에서 class 속성 값이 mName인 select 객체 찾기
    const selectMName = $('select.mName');

    $selectMajorUniObj.on('change', () => {
        selectMName.empty();
        let option, text;
        switch ($selectMajorUniObj.val()) {
            case '소프트웨어융합대학':
                option = $('<option>').text('컴퓨터공학과');
                selectMName.append(option);
                selectMName.css('display', 'inline-block');
                option = $('<option>').text('인공지능학과');
                selectMName.append(option);
                selectMName.css('display', 'inline-block');
                break;
            case '정경대학':
                option = $('<option>').text('경제학과');
                selectMName.append(option);
                selectMName.css('display', 'inline-block');
                option = $('<option>').text('무역학과');
                selectMName.append(option);
                selectMName.css('display', 'inline-block');
                option = $('<option>').text('행정학과');
                selectMName.append(option);
                selectMName.css('display', 'inline-block');
                break;
            case '후마니타스칼리지교육과정':
                option = $('<option>').text('인문사회');
                selectMName.append(option);
                selectMName.css('display', 'inline-block');
                option = $('<option>').text('체육');
                selectMName.append(option);
                selectMName.css('display', 'inline-block');
                break;
            default:
                selectMName.css('display', 'none');
                break;
        }
    });


})