/**
 * Basic Example - User Agent Parser API
 *
 * This example demonstrates how to use the User Agent Parser API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const useragentparserAPI = require('../index.js');

// Initialize the API client
const api = new useragentparserAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  "ua": "Mozilla/5.0 (Windows NT 6.4) AppleWebKit/537.36.0 (KHTML, like Gecko) Chrome/60.0.0.0 Safari/537.36.0"
};

// Make the API request using callback
console.log('Making request to User Agent Parser API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
