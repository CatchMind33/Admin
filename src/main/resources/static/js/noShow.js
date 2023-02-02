function sendNoshow() {
    const prNick = document.getElementById("prNick").innerText;
    const prIdx = document.getElementById("prIdx").innerText;
    const noShowMsg = document.getElementById("noShow-msg");
    const statusblock = document.getElementById("blockstatus").value;
    console.log(statusblock);

    if(noShowMsg.value == '') {
        alert("메세지를 입력하세요!");
        noShowMsg.focus();
        return false;
    }
    let data1 = {
        nick : prNick,
        idx : prIdx,
        msg : noShowMsg.value,
        status : statusblock}
    $.ajax({
        url: "http://localhost:7070/api/talkAdmin/noShow",
        type: "GET",
        dataType: "json",
        processData: true,
        contentType: "application/json; charset=UTF-8",
        data: data1,
        success: function(result) {
            if (result) {
                console.log(result)
                alert('업데이트 성공!')
                location.href='/user';
                // itemList1.itemList1 = result.data;
                // if(!document.querySelector('#check1').innerText){
                //     itemList1.boolean1 = true;}
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });

    $.ajax({
        url: "http://localhost:7070/user",
        type: "GET",
        // processData: true,
        // contentType: "application/json; charset=UTF-8",
        dataType: "text",
        success: function(result) {
            if (result) {
                console.log(result)
                alert('업데이트 성공!')
                // itemList1.itemList1 = result.data;
                // if(!document.querySelector('#check1').innerText){
                //     itemList1.boolean1 = true;}
            } else {
                alert("전송된 값 없음");
            }
        },
        error: function() {
            alert("에러 발생");
        }
    });

    // fetch("http://localhost:7070/api/talkAdmin/noShow", {
    //     method: "POST",
    //     headers: {'Content-Type': 'application/json'},
    //     body: JSON.stringify({
    //         "transaction_time": `${new Date()}`,
    //         "resultCode": "ok",
    //         "description": "정상",
    //         "data": {
    //             "taaNick": `${prNick}`,
    //             "taaContent": `${noShowMsg.value}`,
    //             "prIdx" : `${prIdx}`,
    //             "statusblock" : `${statusblock}`
    //         }
    //     }),
    // })
    //     .then((res) => {
    //         alert('메세지 보내기 성공!')
    //         location.href='/user/detail/' + prIdx;
    //     })
    //     .then((data) => {
    //         console.log(data);
    //         return;
    //     })
    //     .catch((err) => {
    //         alert('다시확인해주세요!');
    //         location.reload();
    //         return;
    //     });

}