window.onload = function(){
    const btn = document.getElementById('update_btn');
    btn.addEventListener('click', sendit);
}

function sendit(){
    const noTitle = document.getElementById('noTitle');
     const noIdx = document.getElementById('notice_update');
    const noContent = document.getElementById('noContent');
    if(noTitle.value == ''){
        alert('제목을 입력하세요');
        noTitle.focus()
        return false;
    }


    if(noContent.value == ''){
        alert('내용을 입력하세요');
        noContent.focus()
        return false;
    }



    fetch('http://localhost:9999/api', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "noTitle":`${noTitle.value}`,
                "noIdx":`${noIdx.value}`,
                "noContent":`${noContent.value}`
            }
        }),
    })
        .then((res) => {
            alert('수정완료!')
            location.href='/service/notice'
            return;
        })

        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}