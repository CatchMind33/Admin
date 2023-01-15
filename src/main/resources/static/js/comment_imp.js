window.onload = function(){
    const btn = document.getElementById('imp_btn');
    btn.addEventListener('click', impp);
}

function impp(){
    const impAnswer = document.getElementById('input_imp').value;
    const impIdx = document.getElementById('imp_idx').value;
    // console.log(askAnswer,askIdx)
    fetch('http://localhost:9999/impapi/'+impIdx, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
            "transaction_time":`${new Date()}`,
            "resultCode":"ok",
            "description":"정상",
            "data":{
                "impIdx":impIdx,
                "impAnswer":impAnswer
            }
        }),
    })
        .then((res) => {
            alert('답글 등록 완료!')
            location.reload()
            return;
        })

        .catch((err) => {
            alert('에러!!');
            location.reload();
            return;
        });
}





