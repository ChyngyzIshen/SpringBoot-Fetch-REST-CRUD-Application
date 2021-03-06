function getUsers() {
    fetch("http://localhost:8888/getAllUsers").then((res) => res.json())
        .then((data) => {
            let output = "";
            data.forEach(function (user) {

                let userRoles = "";
                for (let i = 0; i < user.roles.length; i++){
                    userRoles+=`${user.roles[i].name} `
                }

                output += `
                <tr>
                <td id="id${user.id}">${user.id}</td>
                <td id="name${user.id}">${user.name}</td> 
                <td id="lastName${user.id}">${user.lastName}</td>
                <td id="age${user.id}">${user.age}</td>
                <td id="email${user.id}">${user.email}</td>
                <td id="roles${user.id}">${userRoles}</td>
                <td>
                <a class="btn btn-info" role="button"
                data-toggle="modal" data-target="#editModal" id="callModalEdit"
                onclick="openEditModal(${user.id})">Edit</a>
                </td>
                <td>
                <a class="btn btn-danger" role="button"
                data-toggle="modal" data-target="#deleteModal" id="delete-post"
                onclick="openDeleteModal(${user.id})">Delete</a>
                </td>
              </tr>
          `;
            });
            document.getElementById("getAllUsers").innerHTML = output;
        })
}
getUsers()
