function sendPendingMsg() {
    const resaBisName = document.getElementById("bis-name").innerText;
    const penIdx = document.getElementById("pen-idx").value;
    const pendingMsg = document.getElementById("pendingMsg");

    if(pendingMsg.value == '') {
        alert("메세지를 입력하세요!");
        pendingMsg.focus();
        return false;
    }

    fetch("http://localhost:7070/api/talkAdmin/pending", {
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({
            "transaction_time": `${new Date()}`,
            "resultCode": "ok",
            "description": "정상",
            "data": {
                "taaResaBisName": `${resaBisName}`,
                "taaContent": `${pendingMsg.value}`
            }
        }),
    })
        .then((res) => {
            alert('메세지 보내기 성공!')
            location.href='/owner/new/detail/' + penIdx;
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