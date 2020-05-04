/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jaxws.osgi.bridge;

import com.liferay.registry.Registry;
import com.liferay.registry.RegistryUtil;
import com.liferay.registry.ServiceTracker;

import java.net.URL;

import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Endpoint;
import javax.xml.ws.EndpointReference;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.spi.Invoker;
import javax.xml.ws.spi.ServiceDelegate;
import javax.xml.ws.wsaddressing.W3CEndpointReference;

import org.w3c.dom.Element;

/**
 * @author Carlos Sierra Andrés
 */
public class Provider extends javax.xml.ws.spi.Provider {

	public Provider() {
		Registry registry = RegistryUtil.getRegistry();

		_serviceTracker = registry.trackServices(
			javax.xml.ws.spi.Provider.class);

		_serviceTracker.open();
	}

	@Override
	public Endpoint createAndPublishEndpoint(
		String address, Object implementor) {

		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.createAndPublishEndpoint(address, implementor);
	}

	@Override
	public Endpoint createAndPublishEndpoint(
		String address, Object implementor,
		WebServiceFeature... webServiceFeatures) {

		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.createAndPublishEndpoint(
			address, implementor, webServiceFeatures);
	}

	@Override
	public Endpoint createEndpoint(
		String bindingId, Class<?> implementorClass, Invoker invoker,
		WebServiceFeature... webServiceFeatures) {

		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.createEndpoint(
			bindingId, implementorClass, invoker, webServiceFeatures);
	}

	@Override
	public Endpoint createEndpoint(String bindingId, Object implementor) {
		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.createEndpoint(bindingId, implementor);
	}

	@Override
	public Endpoint createEndpoint(
		String bindingId, Object implementor,
		WebServiceFeature... webServiceFeatures) {

		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.createEndpoint(
			bindingId, implementor, webServiceFeatures);
	}

	@Override
	public ServiceDelegate createServiceDelegate(
		URL wsdlURL, QName serviceQName,
		Class<? extends Service> serviceClass) {

		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.createServiceDelegate(
			wsdlURL, serviceQName, serviceClass);
	}

	@Override
	public ServiceDelegate createServiceDelegate(
		URL wsdlURL, QName serviceQName, Class<? extends Service> serviceClass,
		WebServiceFeature... webServiceFeatures) {

		return getProvider().createServiceDelegate(
			wsdlURL, serviceQName, serviceClass, webServiceFeatures);
	}

	@Override
	public W3CEndpointReference createW3CEndpointReference(
		String address, QName serviceQName, QName portQName,
		List<Element> metadataElements, String wsdlURL,
		List<Element> referenceParameterElements) {

		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.createW3CEndpointReference(
			address, serviceQName, portQName, metadataElements, wsdlURL,
			referenceParameterElements);
	}

	@Override
	public W3CEndpointReference createW3CEndpointReference(
		String address, QName interfaceQName, QName serviceQName,
		QName portQName, List<Element> metadata, String wsdlURL,
		List<Element> referenceParameters, List<Element> elements,
		Map<QName, String> attributes) {

		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.createW3CEndpointReference(
			address, interfaceQName, serviceQName, portQName, metadata, wsdlURL,
			referenceParameters, elements, attributes);
	}

	@Override
	public <T> T getPort(
		EndpointReference endpointReference, Class<T> serviceEndpointInterface,
		WebServiceFeature... webServiceFeatures) {

		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.getPort(
			endpointReference, serviceEndpointInterface, webServiceFeatures);
	}

	@Override
	public EndpointReference readEndpointReference(Source source) {
		javax.xml.ws.spi.Provider provider = getProvider();

		return provider.readEndpointReference(source);
	}

	protected javax.xml.ws.spi.Provider getProvider() {
		try {
			javax.xml.ws.spi.Provider provider = _serviceTracker.waitForService(
				10_000L);

			if (provider == null) {
				throw new IllegalStateException(
					"The JAX-WS API bridge is not properly initialized. " +
						"Please configure it in System Settings.");
			}

			return provider;
		}
		catch (InterruptedException interruptedException) {
			throw new RuntimeException(interruptedException);
		}
	}

	private final ServiceTracker
		<javax.xml.ws.spi.Provider, javax.xml.ws.spi.Provider> _serviceTracker;

}