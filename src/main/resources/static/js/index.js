
const badge=document.querySelector('.my-badge')

function addTocart(){
  const productname = 'bag'
   
fetch(`http://localhost:8080/api/addTocart/${productname}`, {
    method: 'post',
    headers: {
        "Content-type": "application/x-www-form-urlencoded; charset=UTF-8"
    },credentials: "same-origin",
    body: JSON.stringify(productname)
    })
    .then(function (data) {
    console.log('Request succeeded with JSON response', data);
     let value=  parseInt(badge.innerHTML);
   badge.innerHTML=value++

   console.log(badge.innerHTML=value++);
    })
    .catch(function (error) {
    console.log('Request failed', error);
    });
}
