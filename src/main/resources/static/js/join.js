window.onload = function () {
    const btn = document.getElementById('joinBtn');
    btn.addEventListener('click', sendit)
}

function sendit() {
    const adUserid = document.getElementById("adUserid");
    const adUserpw = document.getElementById('adUserpw');
    const adName = document.getElementById('adName');
    const adHp = document.getElementById('adHp');
    const adEmail = document.getElementById('adEmail');

    if (adUserid.value == '') {
        alert('아이디를 입력하세요!');
        adUserid.focus();
        return false;
    }

    if (adUserpw.value == '') {
        alert('비밀번호를 입력하세요!');
        adUserpw.focus();
        return false;
    }

    if (adName.value == '') {
        alert('이름을 입력하세요!')
        adName.focus();
        return false;
    }

    if (adHp.value == '') {
        alert('핸드폰번호를 입력하세요!')
        adHp.focus();
        return false;
    }

    if (adEmail.value == '') {
        alert('이메일을 입력하세요!');
        adEmail.focus();
        return false;
    }

    const api = "http://localhost:7070/api/join";

    fetch(api, {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "OK",
            "description": "정상",
            "data": {
                "adUserid": `${adUserid.value}`,
                "adUserpw": `${adUserpw.value}`,
                "adName": `${adName.value}`,
                "adHp": `${adHp.value}`,
                "adEmail": `${adEmail.value}`
            }
        }),
    })
        .then((res) => {
            alert('가입성공!')
            location.href='/login';
        })
        .then((data) => {
            console.log(data);
            return;
        })
        .catch((err) => {
            alert('다시확인해주세요!');
            location.reload();
            return;
        });
}