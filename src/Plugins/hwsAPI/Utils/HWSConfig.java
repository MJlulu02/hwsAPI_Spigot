package Plugins.hwsAPI.Utils;

import redis.clients.jedis.Jedis;

public class HWSConfig {

	private String redis_ip = null, redis_pass = null;
	private int redis_port = 6379;

	private Jedis jedisclient = null;

	public Jedis GetJedis() {
		if (jedisclient != null && this.redis_pass != null && this.jedisclient.isConnected()) {
			jedisclient.auth(this.redis_pass);
		}

		return jedisclient;
	}

	public int getRedis_port() {
		return redis_port;
	}

	public void setRedis_port(int redis_port) {
		this.redis_port = redis_port;
	}

	public String getRedis_ip() {
		return redis_ip;
	}

	public void setRedis_ip(String redis_ip) {
		this.redis_ip = redis_ip;
	}

	public String getRedis_pass() {
		return redis_pass;
	}

	public void setRedis_pass(String redis_pass) {
		this.redis_pass = redis_pass;
	}

	public boolean connect_redis() {
		if (this.jedisclient != null) {
			return true;
		} else if (this.getRedis_ip() == null) {
			return false;
		}
		// Init Connection
		this.jedisclient = new Jedis(this.getRedis_ip(), this.getRedis_port());
		if (!this.jedisclient.isConnected()) {
			this.jedisclient = null;
			return false;
		}

		return true;
	}

}
