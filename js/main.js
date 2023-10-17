const backURL = 'http://192.168.1.19:8888/kosa_web_ucr'
const frontURL = 'http://192.168.1.19:5500/html'

function ajaxHandler(method, u, target) {
    // jQuery 용 메서드 load, 사용설명서 보기
    if (method == 'GET') {
        target.load(u, function (response, status, xhr) {
            if (status == "error") {
                alert(xhr.status + xhr.statusText)
            }
        })
    }
}

$(() => {
    const loginedId = localStorage.getItem("loginedId")
    if (loginedId) {
    } else {
        alert("로그인이 필요합니다")
        window.location.href = location.href = frontURL + "/login.html"
    }
    const $sectionObj = $('section')
    const $menus = $('nav>a')
    $(document).ready(function () {
        // 초기 페이지 설정
        ajaxHandler('GET', "./notice.html", $sectionObj);
        if (loginedId.length < 7) {
            $('nav>a.wishlist').hide()
            $('nav>a.registration').hide()
        }
        //날짜로 기능제어(희망강좌/수강신청)
        // $('nav>a.wishlist').hide()
        // $('nav>a.registration').hide()

        // ----메뉴객체에서 클릭 이벤트가 발생했을 때 할 일 START---
        $menus.click((e) => {
            //menu
            switch (e.target.className) {
                case 'logout':
                    $.ajax({
                        xhrFields: {
                            withCredentials: true
                        },
                        url: backURL + '/logout',
                        success: () => {
                            localStorage.removeItem('loginedId')
                            location.href = frontURL + "/login.html"
                        },
                        error: () => {
                            alert('로그아웃 실패')
                        }
                    })
                    break
                case 'notice':
                    ajaxHandler('GET', "./notice.html", $sectionObj)
                    sessionStorage.setItem('currentPage',1)
                    break
                case 'searchCourse':
                    if (loginedId.length > 7) {
                        ajaxHandler('GET', "./search_course.html", $sectionObj)
                    } else {
                        ajaxHandler('GET', "./professor.html", $sectionObj)
                    }
                    break
                case 'wishlist':
                    ajaxHandler('GET', "./wishlist.html", $sectionObj)
                    break
                case 'registration':
                    ajaxHandler('GET', "./registration.html", $sectionObj)
                    break

            }
            e.preventDefault()
            // ----메뉴객체에서 클릭 이벤트가 발생했을 때 할 일 END----

            //--로그img객체에서 클릭 이벤트가 발생했을 때 할 일 START----
            //main.html로 URL이동
            $('header>img').click(() => {
                sessionStorage.setItem('currentPage',1)
                location.href = './main.html'
            })
        })

        //--로그img객체에서 클릭 이벤트가 발생했을 때 할 일 END----
    })

    // --실시간 시계 START ---
    $(() => {
        const $footer = $('footer');
        const $serverTime = $('<span id="nowTimes"></span>'); // 새로운 span 요소 생성
        $footer.append($serverTime); // footer에 추가

        function realTimer() {
            const nowDate = new Date();
            const year = nowDate.getFullYear();
            const month = nowDate.getMonth() + 1;
            const date = nowDate.getDate();
            const hour = nowDate.getHours();
            const min = nowDate.getMinutes();
            const sec = nowDate.getSeconds();

            // 시간을 화면에 표시
            $serverTime.html(
                year + "-" + addZero(month) + "-" + addZero(date) + "&nbsp;" +
                hour + ":" + addZero(min) + ":" + addZero(sec)
            );
        }

        // 1자리수의 숫자인 경우 앞에 0을 붙여준다.
        function addZero(num) {
            if (num < 10) {
                return "0" + num;
            }
            return num;
        }

        // 초기 시간 설정 및 주기적으로 시간 업데이트
        realTimer(); // 초기 시간 표시
        setInterval(realTimer, 1000); // 1초마다 시간 업데이트

    })
})
