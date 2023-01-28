function sendMemo() {
    const prIdx = document.getElementById("prIdx").innerText;
    const prMemo = document.getElementById("prMemo");

    console.log(prMemo)
    if(prMemo.value == '') {
        alert("관리자 메모를 입력해주세요!");
        prMemo.focus();
        return false;
    }

    fetch("http://localhost:7070/api/user/memo", {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "prIdx": `${prIdx}`,
                "prMemo": `${prMemo.value}`
            }
        }),
    })
        .then((res) => {
            alert('메모등록 성공!')
            location.href='/user';
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