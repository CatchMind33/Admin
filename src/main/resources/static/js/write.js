window.onload = function(){
    const btn = document.getElementById('notice_btn');
    btn.addEventListener('click', sendit);
}

function sendit(){
    const noTitle = document.getElementById('no_title');
    const adName = document.getElementById('ad_name');
    const noContent = document.getElementById('no_content');

    if(noTitle.value == ''){
        alert('제목을 입력하세요');
        noTitle.focus()
        return false;
    }

    if(adName.value == ''){
        alert('작성자를 입력하세요');
        adName.focus()
        return false;
    }

    if(noContent.value == ''){
        alert('내용을 입력하세요');
        noContent.focus()
        return false;
    }



    fetch('http://localhost:9999/api/notice', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "noTitle":`${no_title.value}`,
                "adName":`${ad_name.value}`,
                "noContent":`${no_content.value}`
            }
        }),
    })
        .then((res) => {
            alert('등록성공')
            location.href='/service/notice'
            return;
        })
        // .then((data) => {
        //     console.log(data.json());
        //     return;
        // })
        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}