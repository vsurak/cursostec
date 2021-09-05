import { Querymanager } from './data/querymanager';

class App {

    constructor() {
    }

    public addOwner(pNewUser: any) : void {        
        var queries = new Querymanager();
        queries.addOwner(pNewUser)
        .then(
            ()=> {
                    console.log("se salvo");
                }
        )
        .catch(
            (err) => {
                        console.log(err)
                    }
        );
    };

    public listAllUsers() : void {
        var queries = new Querymanager();
        var allusers = queries.getAllUsers()
        .then((allusers:any) => {
            console.log(JSON.stringify(allusers, null, 2));
            console.log("---------------------------------");
        })
        .catch((err:any) => {console.log(err)})
    }

    public listSomeUsers() : void {
        var queries = new Querymanager();
        var users = queries.getSomeUsers(8)
        .then((allusers:any) => {
            console.log(JSON.stringify(allusers, null, 2));
            console.log("---------------------------------");
        })
        .catch((err:any) => {console.log(err)})
    }

};

var miApp = new App();

var newUser = {
    lastname: "nunez",
    firstname: "rodrigo",
    email: "rrrrrr@mailinator.com",
    password: "123456",
    enabled: true,
    creationdate: '08/18/2021'
};

//miApp.addOwner(newUser);
miApp.listAllUsers();
miApp.listSomeUsers();
