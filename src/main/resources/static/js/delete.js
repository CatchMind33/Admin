function deleteit(num){
    const noIdx = num;
    console.log(num)

    fetch('http://localhost:7070/api/delete/'+noIdx, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "noIdx":`${noIdx}`
            }
        }),
    })
        .then((res) => {
            alert('삭제 완료!')
            location.href='/service/notice'
            return;
        })

        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}