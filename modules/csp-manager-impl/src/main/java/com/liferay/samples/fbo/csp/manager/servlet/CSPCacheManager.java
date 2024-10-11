package com.liferay.samples.fbo.csp.manager.servlet;

import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.cache.SingleVMPool;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = CSPCacheManager.class)
public class CSPCacheManager {
	
	
	@Activate
	protected void activate() {
		_portalCache = (PortalCache<String, InlineCacheItem>) _singleVMPool.getPortalCache(CACHE_NAME);
	}
	
	@Deactivate
	public void deactivate() {
		_singleVMPool.removePortalCache(CACHE_NAME);
	}
	
	private PortalCache<String, InlineCacheItem> _portalCache;
	
	protected static final String CACHE_NAME = CSPCacheManager.class.getName();
    
    @Reference
    private SingleVMPool _singleVMPool;

	public InlineCacheItem get(InlineKey key) {
		return _portalCache.get(key.toString());
	}

	public void put(InlineKey key, InlineCacheItem content) {
		_portalCache.put(key.toString(), content);		
	}

}
