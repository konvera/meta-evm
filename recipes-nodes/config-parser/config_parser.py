#!/usr/bin/env python3

import json
import sys

def parse_and_print_exports(json_file):
    try:
        with open(json_file, 'r') as f:
            data = json.load(f)
        
        if not isinstance(data, dict):
            raise ValueError("JSON file must contain a single object")
        
        for key, value in data.items():
            if not isinstance(key, str) or not isinstance(value, str):
                raise ValueError(f"Invalid key-value pair: {key}: {value}")
            print(f"export {key}='{value}'")
    
    except json.JSONDecodeError as e:
        print(f"Error decoding JSON: {e}", file=sys.stderr)
        sys.exit(1)
    except ValueError as e:
        print(f"Error in JSON structure: {e}", file=sys.stderr)
        sys.exit(1)
    except Exception as e:
        print(f"Unexpected error: {e}", file=sys.stderr)
        sys.exit(1)

if __name__ == "__main__":
    if len(sys.argv) != 2:
        print("Usage: ./parse_json.py <json_file>", file=sys.stderr)
        sys.exit(1)
    
    parse_and_print_exports(sys.argv[1])