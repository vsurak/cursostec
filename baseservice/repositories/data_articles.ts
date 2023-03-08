import { Logger } from '../common'


export class articles_data {
    private log: Logger;

    public constructor()
    {
        // via singleton, accediendo a un solo pool tengo una conexiona la base de datos
    }

    public getAllArticles() : Promise<any>
    {
        const articles = [
            {
              title: "The Mystery of the Missing Diamond",
              author: "John Doe",
              date: "March 1, 2023",
              content: "Lorem ipsum dolor sit amet, consectetur adipiscing elit..."
            },
            {
              title: "A Trip to Mars",
              author: "Jane Smith",
              date: "February 28, 2023",
              content: "Lorem ipsum dolor sit amet, consectetur adipiscing elit..."
            },
            {
              title: "The Haunted Mansion",
              author: "Mark Johnson",
              date: "February 27, 2023",
              content: "Lorem ipsum dolor sit amet, consectetur adipiscing elit..."
            }
          ];        
        // llamadas a SP, driver de base de datos, ORM
        return new Promise((resolve:any) => {
            resolve(articles);
        });
    }

}