import time
import stomp

conn = stomp.Connection(host_and_ports=[('localhost', 61616)])
conn.connect('user', 'pass', wait=True)
time.sleep(2)
conn.send(body='Hello World from Python!', destination='/queue/test')


conn.disconnect()
