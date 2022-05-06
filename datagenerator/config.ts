export const configurations = 
[
    {
        quantity : 3000,
        minstickyness: 10,
        maxstickyness: 20,
        filename : "sample.dat",
        fields : [
            {
                fieldname: "id",
                type: "consecutive",
                starting: 1,
                increment: 1,
            },
            {
                fieldname: "posttime",
                type: "date",
                distributions: [
                    {
                        percentageMin : 0.0,
                        percentageMax : 0.7,
                        days: [4,5,6,7],
                        months: [0,3,4,5,6,7,8],
                        years: [2021, 2021]
                    },
                    {
                        percentageMin : 0.7,
                        percentageMax : 1.00,
                        days: [1,2,3,4,5,6,7],
                        months: [0,1,2,3,4,5,6,7,8,9,11,10],
                        years: [2020, 2021]
                    }
                ]
            },
            {
                fieldname: "fullname",
                type: "combinations",
                sourceA: ["Kathleen","Keelan","Hayli","Pablo", "Pedro", "Ana", "Julio", "Maria", "Yepeto", "Chance","Cassidy","Eva","Amaris","Jasper","Shyanne","Kenneth","Dakota","Deja","Lucy","Porter","Frankie","Jarrod","Bilal","Kolten","Michele","Savanna","Keanu","Nyasia","Jayden","Deandra","Valentina","Jaydon","Cindy","Sheldon","Jane","Blaine","Vicky","Ireland","Ayleen","Jasmin","Braden","Adela","Rico","Varun","Domenic","Madelyn","Grecia","Hattie","Danica","Edwin","Terra","Adolfo","Edgardo","Mollie","Susan","Ester","Zain","Ivanna","Auston","Tionna","Mohammed","Anisha","Halee","Ameer","Kristofer","Zainab","Dorian","Casey","Suzanne","Jacquez","Rayne","Bradly","Long","Trey","Slade","Arron","Javen","Keisha","Ty","Maximiliano","Gunner","Moises","Barbara","Raheem","Clarence","Candy","Jazlynn","Ayana","Lars","Tyreke","Jalin","Kiah","Bethanie","Jamia","Alisha","Jade","Hadley","Misael","Isaac","Tyree","Josef","Brielle","Sage","Daron","Daniella","Cooper"],
                sourceB: ["Lopez", "Arias", "Obando", "Soto", "Corona", "Brynn","Jaylin","Aja","Rasheed","Mckenna","Saul","Emalee","Christiana","Vera","Mauricio","Jarod","Maximiliano","Adia","Mikaila","Sarahi","Jamar","Kelly","Dillan","Uriah","Lydia","Landen","Kara","Brodie","Kaleigh","Pedro","Julian","Yessica","Eli","Kori","Quinlan","Jacklyn","Kameron","Malik","Bruno","Josue","Kennedi","Brynne","Jarrett","Elyssa","Elaina","Sammy","Milan","Jaden","Lyndsay","Dylan","Maeve","Nathalie","Felipe","Karolina","Jevon","Paige","Jan","Clifford","Coleton","Lukas","Gladys","Austyn","Aric","Aileen","Collin","Courtney","Warren","German","Benny","Deion","Abriana","Izabella","Misty","Kiley","Nikolas","Brannon","Analisa","Valentin","Ricardo","Keelan","Libby","Marion","Aniya","Joanne","Iman","Danyelle","Brenton","Davis","Madalyn","Annamarie","Jordan","Deanna","Jackie","Kassandra","Amaya","Marguerite","Beth","Ramsey","Bella","Johanna","Edith","Joelle","Tanner","Zion","Eileen"],
                sticky: true
            },
            {
                fieldname: "description",
                type: "text",
                unique: false,
                source: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut",
            },
            {
                fieldname: "gender",
                type: "option",
                source: ["female", "male"],
                sticky: true
            },        
            {
                fieldname: "age",
                type: "number",
                min: 33,
                max: 45,
                sticky: true
            },
            {
                fieldname: "country",
                type: "option",
                source: ["usa", "costa rica", "mexico", "usa", "canada", "germany", "canada", "costa rica"],
                sticky: true
            },
            ,
            {
                fieldname: "metaverso",
                type: "option",
                source: ["Fester","Slasher","Fisheye","Steelshot","Flack","Surge","Gargoyle","Sythe","Grave","Trip","Gunner","Trooper","Hash","Tweek","Hashtag","Vein","Indominus","Void","Ironclad","Wardon","Killer","Wraith","Knuckles","Zero","Steel","Kevlar","Lightning","Tito","Bullet-Proof","Fire-Bred","Titanium","Hurricane","Ironsides","Iron-Cut"," Tempest","Iron Heart","Steel Forge","Pursuit","Steel Foil","Sick Rebellious Names","Upsurge","Uprising","Overthrow","Breaker","Sabotage","Dissent","Subversion"],
                sticky: true
            }
            ,
            {
                fieldname: "tag1",
                type: "option",
                source: ["shop", "tech", "sports", "entertainment", "news", "design", "research", "basketball", "soccer", "tennis", "swin", "dance", "drink", "marketing", "healthcare", "food", "travel", "game", "art", "techsupport", "education", "physics", "music", "puzzle", "dating"],
            },
            {
                fieldname: "tag2",
                type: "option",
                source: ["city", "car", "remote", "parks", "street", "camping", "sky", "social", "books", "nature", "landscape", "building", "personalcare", "ocean", "mountains", "warm", "cold"],
            },
            {
                fieldname: "actiontype",
                type: "option",
                source: ["jump", "run", "login", "buy", "build", "create", "craft", "hangout", "walk", "design", "look", "sleep", "watch", "lab", "write", "read", "draw", "paint", "blockbuilder", "farm", "meet", "training", "learn", "practice"],
            },
            {
                fieldname: "timespent",
                type: "number",
                min: 10,
                max: 50,
            },
            {
                fieldname: "coinsspent",
                type: "option",
                source: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,5,10,20,50,100],
            },
            {
                fieldname: "coinsearned",
                type: "option",
                source: [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,5,10,20,50],
            },
        ]
    }
]