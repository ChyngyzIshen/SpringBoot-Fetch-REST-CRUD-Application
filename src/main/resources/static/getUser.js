const url = "http://localhost:8888/getUser"

function getUser() {

    fetch(url).then((res) => res.json())
        .then((user) => {
            let userRoles = "";
            for (let i = 0; i < user.roles.length; i++) {
                userRoles += `${user.roles[i].name} `
            }

            let output = "<tr>";
            output += `
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.age}</td>
                <td>${user.email}</td>
                <td>${user.password}</td>
                <td>${userRoles}</td>
            `;
            output += "<tr>";

            document.getElementById("getUser").innerHTML = output;
        })
}

getUser()