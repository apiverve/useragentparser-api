# User Agent Parser API - PHP Package

User Agent Parser parses user agent strings to extract browser, operating system, and hardware details. It identifies device types, CPU architecture, and bot traffic, so you can run user agent detection on every incoming HTTP request.

## Installation

Install via Composer:

```bash
composer require apiverve/useragentparser
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Useragentparser\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['ua' => 'Mozilla/5.0 (Windows NT 6.4) AppleWebKit/537.36.0 (KHTML, like Gecko) Chrome/60.0.0.0 Safari/537.36.0']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Useragentparser\Client;
use APIVerve\Useragentparser\Exceptions\APIException;
use APIVerve\Useragentparser\Exceptions\ValidationException;

try {
    $response = $client->execute(['ua' => 'Mozilla/5.0 (Windows NT 6.4) AppleWebKit/537.36.0 (KHTML, like Gecko) Chrome/60.0.0.0 Safari/537.36.0']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "ua": "Mozilla/5.0 (Windows NT 6.4) AppleWebKit/537.36.0 (KHTML, like Gecko) Chrome/60.0.0.0 Safari/537.36.0",
    "browser": {
      "name": "Chrome",
      "version": "60.0.0.0",
      "major": "60"
    },
    "engine": {
      "name": "Blink",
      "version": "60.0.0.0"
    },
    "os": {
      "name": "Windows",
      "version": "10"
    },
    "device": {},
    "cpu": {},
    "isMobile": false,
    "isBot": false,
    "deviceType": "desktop",
    "summary": "Chrome 60 on Windows 10"
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/useragentparser?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/useragentparser?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/useragentparser?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
