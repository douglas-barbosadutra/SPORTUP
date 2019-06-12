
export class User {
    id: number;
    username: string;
    password: string;
    type: string;



    // tslint:disable-next-line:max-line-length
    constructor(id: number, username: string, password: string, type: string) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

}