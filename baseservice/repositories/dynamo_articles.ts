import * as AWS from 'aws-sdk'
import { Logger } from '../common'


export class articles_data {
    private log: Logger;
    private dyClient: AWS.DynamoDB.DocumentClient;

    public constructor()
    {
        this.dyClient =  new AWS.DynamoDB.DocumentClient({"region": "us-east-1"});
    }

    public getAllArticles() : Promise<any>
    {
        const params = {
            TableName : 'articles',
            KeyConditionExpression: 'author = :elautor',
            ExpressionAttributeValues: {
                ':elautor': 'rodrigo valdes'
            }        
        };

        return this.dyClient.query(params).promise();
    }

}