// const edit = document.getElementById('admin-page');
// let url = 'http://localhost:8088/admin-page';
//
// edit.addEventListener('submit',   async function (event) {
//     event.preventDefault();
//
//     let firstName = document.getElementById('firstName').value;
//     let lastName = document.getElementById('lastName').value;
//     let age = document.getElementById('age').value;
//     let email = document.getElementById('email').value;
//     let password = document.getElementById('password').value;
//
//     let response = await fetch(url, {
//         method: "POST",
//         headers: {
//             'Content-Type': 'application/json'
//         },
//         body: JSON.stringify({
//             firstName: firstName,
//             lastName: lastName,
//             age: age,
//             email: email,
//             password: password
//         })
//     });
//
//     let answer = await response.json();
//     console.log(answer);
// });

// fetch(url) // Call the fetch function passing the url of the API as a parameter
//     .then(function() {
// // Your code for handling the data you get from the API
//     })
//     .catch(function() {
// // This is where you run code if the server returns any errors
//     });


$(document).ready(function () {

    $('.table .eBtn').on('click', function (event) {
        event.preventDefault();
        let href = $(this).attr('href');

        $.get(href, function (user) {
            $('#id').val(user.id);
            $('#firstName').val(user.firstName);
            $('#lastName').val(user.lastName);
            $('#age').val(user.age);
            $('#email').val(user.email);
            $('#role').val(user.role);
        });

        $('#editModal').showModal();
    });

});