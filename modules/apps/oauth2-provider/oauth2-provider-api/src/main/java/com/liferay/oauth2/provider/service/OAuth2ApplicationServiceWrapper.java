/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link OAuth2ApplicationService}.
 *
 * @author Brian Wing Shun Chan
 * @see OAuth2ApplicationService
 * @generated
 */
public class OAuth2ApplicationServiceWrapper
	implements OAuth2ApplicationService,
			   ServiceWrapper<OAuth2ApplicationService> {

	public OAuth2ApplicationServiceWrapper(
		OAuth2ApplicationService oAuth2ApplicationService) {

		_oAuth2ApplicationService = oAuth2ApplicationService;
	}

	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			addOAuth2Application(
				java.util.List<com.liferay.oauth2.provider.constants.GrantType>
					allowedGrantTypesList,
				long clientCredentialUserId, String clientId, int clientProfile,
				String clientSecret, String description,
				java.util.List<String> featuresList, String homePageURL,
				long iconFileEntryId, String name, String privacyPolicyURL,
				java.util.List<String> redirectURIsList,
				java.util.List<String> scopeAliasesList,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.addOAuth2Application(
			allowedGrantTypesList, clientCredentialUserId, clientId,
			clientProfile, clientSecret, description, featuresList, homePageURL,
			iconFileEntryId, name, privacyPolicyURL, redirectURIsList,
			scopeAliasesList, serviceContext);
	}

	/**
	 * @deprecated As of Mueller (7.2.x)
	 */
	@Deprecated
	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			addOAuth2Application(
				java.util.List<com.liferay.oauth2.provider.constants.GrantType>
					allowedGrantTypesList,
				String clientId, int clientProfile, String clientSecret,
				String description, java.util.List<String> featuresList,
				String homePageURL, long iconFileEntryId, String name,
				String privacyPolicyURL,
				java.util.List<String> redirectURIsList,
				java.util.List<String> scopeAliasesList,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.addOAuth2Application(
			allowedGrantTypesList, clientId, clientProfile, clientSecret,
			description, featuresList, homePageURL, iconFileEntryId, name,
			privacyPolicyURL, redirectURIsList, scopeAliasesList,
			serviceContext);
	}

	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			deleteOAuth2Application(long oAuth2ApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.deleteOAuth2Application(
			oAuth2ApplicationId);
	}

	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			fetchOAuth2Application(long companyId, String clientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.fetchOAuth2Application(
			companyId, clientId);
	}

	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			getOAuth2Application(long oAuth2ApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.getOAuth2Application(
			oAuth2ApplicationId);
	}

	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			getOAuth2Application(long companyId, String clientId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.getOAuth2Application(
			companyId, clientId);
	}

	@Override
	public java.util.List<com.liferay.oauth2.provider.model.OAuth2Application>
		getOAuth2Applications(
			long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.oauth2.provider.model.OAuth2Application>
					orderByComparator) {

		return _oAuth2ApplicationService.getOAuth2Applications(
			companyId, start, end, orderByComparator);
	}

	@Override
	public int getOAuth2ApplicationsCount(long companyId) {
		return _oAuth2ApplicationService.getOAuth2ApplicationsCount(companyId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _oAuth2ApplicationService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application updateIcon(
			long oAuth2ApplicationId, java.io.InputStream inputStream)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.updateIcon(
			oAuth2ApplicationId, inputStream);
	}

	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			updateOAuth2Application(
				long oAuth2ApplicationId,
				java.util.List<com.liferay.oauth2.provider.constants.GrantType>
					allowedGrantTypesList,
				long clientCredentialUserId, String clientId, int clientProfile,
				String clientSecret, String description,
				java.util.List<String> featuresList, String homePageURL,
				long iconFileEntryId, String name, String privacyPolicyURL,
				java.util.List<String> redirectURIsList,
				long auth2ApplicationScopeAliasesId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.updateOAuth2Application(
			oAuth2ApplicationId, allowedGrantTypesList, clientCredentialUserId,
			clientId, clientProfile, clientSecret, description, featuresList,
			homePageURL, iconFileEntryId, name, privacyPolicyURL,
			redirectURIsList, auth2ApplicationScopeAliasesId, serviceContext);
	}

	/**
	 * @deprecated As of Mueller (7.2.x)
	 */
	@Deprecated
	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			updateOAuth2Application(
				long oAuth2ApplicationId,
				java.util.List<com.liferay.oauth2.provider.constants.GrantType>
					allowedGrantTypesList,
				String clientId, int clientProfile, String clientSecret,
				String description, java.util.List<String> featuresList,
				String homePageURL, long iconFileEntryId, String name,
				String privacyPolicyURL,
				java.util.List<String> redirectURIsList,
				long auth2ApplicationScopeAliasesId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.updateOAuth2Application(
			oAuth2ApplicationId, allowedGrantTypesList, clientId, clientProfile,
			clientSecret, description, featuresList, homePageURL,
			iconFileEntryId, name, privacyPolicyURL, redirectURIsList,
			auth2ApplicationScopeAliasesId, serviceContext);
	}

	@Override
	public com.liferay.oauth2.provider.model.OAuth2Application
			updateScopeAliases(
				long oAuth2ApplicationId,
				java.util.List<String> scopeAliasesList)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _oAuth2ApplicationService.updateScopeAliases(
			oAuth2ApplicationId, scopeAliasesList);
	}

	@Override
	public OAuth2ApplicationService getWrappedService() {
		return _oAuth2ApplicationService;
	}

	@Override
	public void setWrappedService(
		OAuth2ApplicationService oAuth2ApplicationService) {

		_oAuth2ApplicationService = oAuth2ApplicationService;
	}

	private OAuth2ApplicationService _oAuth2ApplicationService;

}