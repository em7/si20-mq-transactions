import stomp
import time

class MyListener(stomp.ConnectionListener):
    def on_error(self, headers, message):
        print('error "%s"' % message)
    def on_message(self, headers, message):
        print('message "%s"' % message)

conn = stomp.Connection(host_and_ports=[('localhost', 61616)])
conn.set_listener('', MyListener())
conn.connect('user', 'pass', wait=True)

conn.subscribe(destination='/queue/test', id="1", ack="auto")

time.sleep(10)
conn.disconnect()
