import { HatePost, Logger } from '../common'
import * as mongoose from 'mongoose';

const objectostohate = ["los gatos", "las bicis","la basura", "madrugar", "ver tele", "los cuervos", "el aguacate", "tv azteca"];
const allhashtags =  ["#malavibra", "#nohate", "#everyday", "#oneday", "#popular", "#otrohashtag", "#region", "#mapa", "#rojo", "#blackhole"];

export class HateController {
    private static instance: HateController;
    private log: Logger;
    private db : any;

    private constructor()
    {
        this.log = new Logger();
        try
        {
            mongoose.connect('mongodb://10.0.0.6:27017/socialhate',
            {
                useNewUrlParser: true,
                useUnifiedTopology: true,
                socketTimeoutMS: 2000
            });
            this.db = mongoose.connection;

            this.db.on('error', () => {
                this.log.error("No puedo conectar a mongo")
            });

            this.db.once('open', ()=> {
                this.log.info("Conectado a mongo")
            });
        } catch (e)
        {
            this.log.error(e);
        }
    }


    public fillHatePosts()
    {
        try
        {
            let quantity = 100;
            while (quantity>0)
            {
                const willpaid = Math.random()<=0.5 ? true : false;
                const amount = willpaid ? (Math.random()*300000.00) + 2000.0 : 0.0;
                const aproxHashtags = Math.trunc(Math.random()*4 + 1) / allhashtags.length;
                const postDate = new Date();
                postDate.setDate(postDate.getDate() - Math.trunc(Math.random()*700));

                const newPost = new HatePost({
                    description: 'Odio '+objectostohate[Math.trunc(Math.random()*objectostohate.length)],
                    paid: willpaid,
                    amountPaid: amount,
                    likes: Math.trunc((Math.random()*30000) + 2000),
                    hashtags: allhashtags.filter(
                        (element, index, array) => {
                            if (Math.random()<=aproxHashtags) {
                                return true;
                            }
                        }
                    ),
                    date: postDate
                });

                newPost.save( (err: any, post: any) => {
                    if (err)
                    {
                        this.log.error(err);
                    }
                });

                quantity--;
            }
        }
        catch(e)
        {
            this.log.error(e);
        }
    }

    public static getInstance() : HateController
    {
        if (!this.instance)
        {
            this.instance = new HateController();
        }
        return this.instance;
    }
}