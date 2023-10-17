const loginBackURL = 'http://192.168.1.19:8888/kosa_web_ucr'
const loginFrontURL = 'http://192.168.1.19:5500/html'


//로그인, 찾기페이지 이동
$(document).ready(function () {
  $('#findid').click(function () {
    $('.bluebox').css('transform', 'translateX(80%)');
    $('.login').addClass('nodisplay');
    $('.findpwd').addClass('nodisplay');
    $('.findid').removeClass('nodisplay');
  });

  $('#findpwd').click(function () {
    $('.bluebox').css('transform', 'translateX(80%)');
    $('.login').addClass('nodisplay');
    $('.findid').addClass('nodisplay');
    $('.findpwd').removeClass('nodisplay');
  });

  $('#login').click(function () {
    $('.bluebox').css('transform', 'translateX(0%)');
    $('.findid').addClass('nodisplay');
    $('.findpwd').addClass('nodisplay');
    $('.login').removeClass('nodisplay');
  });
});


//로그인
$(() => {
  const $formObj = $('section>div.container>div.welcome>div.bluebox>div.login>form.more-padding')
  const savedId = localStorage.getItem('savedId');
  if (savedId != null) {
    $formObj.find('input[name=id]').val(savedId)
  }

  $formObj.find('button').click(() => {
    const $bool = $formObj.find('input[type=checkbox]').prop('checked')
    if ($bool) {
      localStorage.setItem('savedId', $formObj.find('input[name=id]').val())
    } else {
      localStorage.removeItem('savedId')
    }
    const $idValue = $formObj.find('input[name=id]').val()
    const $pwdValue = $formObj.find('input[name=pwd]').val()
    const $data = `id=${$idValue}&pwd=${$pwdValue}`

    if (!$idValue || !$pwdValue) {
      alert('모든 정보를 입력하세요.');
      return false;
    }

    $.ajax({ //$.ajax하면 setRequestHeader를 알아서 처리해줌(할필요X)
      xhrFields: {
        withCredentials: true
      },
      url: loginBackURL + '/login',
      method: 'post',
      data: $data,
      success: (responseJSONObj) => {//요청성공이라 로그인실패여도 여기서 뜸
        if (responseJSONObj.status == 0) { //로그인 실패인 경우
          alert(responseJSONObj.msg)
        } else if (responseJSONObj.status == 1) { //교수로그인 성공인 경우
          localStorage.setItem("loginedId", $idValue)
          location.href = loginFrontURL + "/main.html"
        } else if (responseJSONObj.status == 2) { //학생로그인 성공인 경우
          localStorage.setItem("loginedId", $idValue)
          location.href = loginFrontURL + "/main.html"
        }
      },
      error: () => {
        alert(jqXHR.readyState + ":" + jqXHR.state + ":" + jqXHR.statusText)
      }
    })
    return false
  })
})


//아이디찾기
$(() => {
  const $formObj = $('section>div.container>div.welcome>div.bluebox>div.findid>form')

  $formObj.find('button').click(() => {
    const $nameValue = $formObj.find('input[name=name]').val()
    const $idenValue = $formObj.find('input[name=identifyNumber]').val()
    const $phoneValue = $formObj.find('input[name=phoneNumber]').val()
    const $data = `name=${$nameValue}&idenNum=${$idenValue}&phone=${$phoneValue}`
    
    const $infoBox = $formObj.find('div.foundedInfo')

    if (!$nameValue || !$idenValue || !$phoneValue) {
      alert('모든 정보를 입력하세요.');
      return false;
    }

    $.ajax({
      xhrFields: {
        withCredentials: true
      },
      url: loginBackURL + '/findid',
      method: 'post',
      data: $data,
      success: (responseJSONObj) => {
        if (responseJSONObj.status == 0) {//아이디찾기 실패인 경우
          alert(responseJSONObj.msg)
          $infoBox.addClass('nodisplay')
        } else if (responseJSONObj.status == 1) { //직번찾기 성공인 경우
          $infoBox.removeClass('nodisplay')
          $infoBox.html(responseJSONObj.msg+" : "+responseJSONObj.id)
        } else if (responseJSONObj.status == 2) { //학번찾기 성공인 경우
          $infoBox.removeClass('nodisplay')
          $infoBox.html(responseJSONObj.msg+" : "+responseJSONObj.id)
        }
      },
      error: () => {
        alert(jqXHR.readyState + ":" + jqXHR.state + ":" + jqXHR.statusText)
      }
    })
    return false;
  })
})


//비밀번호찾기
$(() => {
  const $formObj = $('section>div.container>div.welcome>div.bluebox>div.findpwd>form')

  $formObj.find('button').click(() => {
    const $idValue = $formObj.find('input[name=id]').val()
    const $nameValue = $formObj.find('input[name=name]').val()
    const $idenValue = $formObj.find('input[name=identifyNumber]').val()
    const $phoneValue = $formObj.find('input[name=phoneNumber]').val()
    const $data = `id=${$idValue}&name=${$nameValue}&idenNum=${$idenValue}&phone=${$phoneValue}`

    const $infoBox = $formObj.find('div.foundedInfo')

    if (!$idValue || !$nameValue || !$idenValue || !$phoneValue) {
      alert('모든 정보를 입력하세요.');
      return false;
    }

    $.ajax({
      xhrFields: {
        withCredentials: true
      },
      url: loginBackURL + '/findpwd',
      method: 'post',
      data: $data,
      success: (responseJSONObj) => {
        if (responseJSONObj.status == 0) {//비밀번호찾기 실패인 경우
          alert(responseJSONObj.msg)
          $infoBox.addClass('nodisplay')
        } else if (responseJSONObj.status == 1 || responseJSONObj.status == 2) { //비밀번호찾기 성공인 경우
          $infoBox.removeClass('nodisplay')
          $infoBox.html(responseJSONObj.msg+" : "+responseJSONObj.pwd)
        }
      },
      error: () => {
        alert(jqXHR.readyState + ":" + jqXHR.state + ":" + jqXHR.statusText)
      }
    })
    return false;
  })
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