function sendNoshow() {
    const prNick = document.getElementById("prNick").innerText;
    const prIdx = document.getElementById("prIdx").innerText;
    const noShowMsg = document.getElementById("noShow-msg");
    console.log(noShowMsg)

    if(noShowMsg.value == '') {
        alert("메세지를 입력하세요!");
        noShowMsg.focus();
        return false;
    }

    fetch("http://localhost:7070/api/talkAdmin/noShow", {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "taaNick": `${prNick}`,
                "taaContent": `${noShowMsg.value}`
            }
        }),
    })
        .then((res) => {
            alert('메세지 보내기 성공!')
            location.href='/user/detail/' + prIdx;
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