#!/bin/sh
### BEGIN INIT INFO
# Provides:          fetch-config
# Required-Start:    $network
# Required-Stop:     
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: Fetch configuration JSON file
# Description:       Fetch configuration JSON file and set up environment variables
### END INIT INFO

set -e

case "$1" in
  start)
    echo "Fetching configuration..."
    curl -o /etc/config.json http://10.0.2.2:8000/config.json
    if [ $? -eq 0 ]; then
      echo "Configuration fetched successfully."
      source /usr/bin/setup_env.sh
    else
      echo "Failed to fetch configuration."
    fi
    ;;
  stop)
    echo "Nothing to stop."
    ;;
  restart|reload)
    $0 stop
    $0 start
    ;;
  status)
    if [ -f /etc/config.json ]; then
      echo "Configuration file exists."
    else
      echo "Configuration file does not exist."
    fi
    ;;
  *)
    echo "Usage: $0 {start|stop|restart|status}"
    exit 1
    ;;
esac

exit 0