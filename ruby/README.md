# User Agent Parser API - Ruby Gem

User Agent Parser parses user agent strings to extract browser, operating system, and hardware details. It identifies device types, CPU architecture, and bot traffic, so you can run user agent detection on every incoming HTTP request.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_useragentparser'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_useragentparser
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_useragentparser'

# Initialize the client
client = APIVerve::Useragentparser::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ ua: "Mozilla/5.0 (Windows NT 6.4) AppleWebKit/537.36.0 (KHTML, like Gecko) Chrome/60.0.0.0 Safari/537.36.0" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ ua: "Mozilla/5.0 (Windows NT 6.4) AppleWebKit/537.36.0 (KHTML, like Gecko) Chrome/60.0.0.0 Safari/537.36.0" })
  puts response["data"]
rescue APIVerve::Useragentparser::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Useragentparser::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Useragentparser::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/useragentparser?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/useragentparser?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/useragentparser?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
