"""
User Agent Parser API - Basic Usage Example

This example demonstrates the basic usage of the User Agent Parser API.
API Documentation: https://docs.apiverve.com/ref/useragentparser
"""

import os
import requests
import json

API_KEY = os.getenv('APIVERVE_API_KEY', 'YOUR_API_KEY_HERE')
API_URL = 'https://api.apiverve.com/v1/useragentparser'

def call_useragentparser_api():
    """
    Make a POST request to the User Agent Parser API
    """
    try:
        # Request body
        request_body &#x3D; {
    &#x27;ua&#x27;: &#x27;Mozilla/5.0 (Windows NT 6.4) AppleWebKit/537.36.0 (KHTML, like Gecko) Chrome/60.0.0.0 Safari/537.36.0&#x27;
}

        headers = {
            'x-api-key': API_KEY,
            'Content-Type': 'application/json'
        }

        response = requests.post(API_URL, headers=headers, json=request_body)

        # Raise exception for HTTP errors
        response.raise_for_status()

        data = response.json()

        # Check API response status
        if data.get('status') == 'ok':
            print('✓ Success!')
            print('Response data:', json.dumps(data['data'], indent=2))
            return data['data']
        else:
            print('✗ API Error:', data.get('error', 'Unknown error'))
            return None

    except requests.exceptions.RequestException as e:
        print(f'✗ Request failed: {e}')
        return None

if __name__ == '__main__':
    print('📤 Calling User Agent Parser API...\n')

    result = call_useragentparser_api()

    if result:
        print('\n📊 Final Result:')
        print(json.dumps(result, indent=2))
    else:
        print('\n✗ API call failed')
