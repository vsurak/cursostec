"use strict";
exports.__esModule = true;
var express = require("express");
var express_graphql_1 = require("express-graphql");
var graphql_1 = require("graphql");
// Construct a schema, using GraphQL schema language
var schema = (0, graphql_1.buildSchema)("\n  type Query {\n    hello: String\n  }\n");
// The root provides a resolver function for each API endpoint
var root = {
    hello: function () {
        return 'Hello world!';
    }
};
var app = express();
app.use('/graphql', (0, express_graphql_1.graphqlHTTP)({
    schema: schema,
    rootValue: root,
    graphiql: true
}));
app.listen(5000);
console.log('Running a GraphQL API server at http://localhost:5000/graphql');
