/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.social.kernel.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.social.kernel.model.SocialActivity;
import com.liferay.social.kernel.model.SocialActivityFeedEntry;
import com.liferay.social.kernel.model.SocialActivityInterpreter;
import com.liferay.social.kernel.model.SocialActivitySet;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SocialActivityInterpreter. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SocialActivityInterpreterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SocialActivityInterpreterLocalService
	extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SocialActivityInterpreterLocalServiceUtil} to access the social activity interpreter local service. Add custom service methods to <code>com.liferay.portlet.social.service.impl.SocialActivityInterpreterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the activity interpreter to the list of available interpreters.
	 *
	 * @param activityInterpreter the activity interpreter
	 */
	public void addActivityInterpreter(
		SocialActivityInterpreter activityInterpreter);

	/**
	 * Removes the activity interpreter from the list of available interpreters.
	 *
	 * @param activityInterpreter the activity interpreter
	 */
	public void deleteActivityInterpreter(
		SocialActivityInterpreter activityInterpreter);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, List<SocialActivityInterpreter>>
		getActivityInterpreters();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SocialActivityInterpreter> getActivityInterpreters(
		String selector);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Creates a human readable activity feed entry for the activity using an
	 * available compatible activity interpreter.
	 *
	 * <p>
	 * This method finds the appropriate interpreter for the activity by going
	 * through the available interpreters and asking them if they can handle the
	 * asset type of the activity.
	 * </p>
	 *
	 * @param selector the context in which the activity interpreter is used
	 * @param activity the activity to be translated to human readable form
	 * @param serviceContext the service context to be applied
	 * @return the activity feed that is a human readable form of the activity
	 record or <code>null</code> if a compatible interpreter is not
	 found
	 */
	public SocialActivityFeedEntry interpret(
		String selector, SocialActivity activity,
		ServiceContext serviceContext);

	public SocialActivityFeedEntry interpret(
		String selector, SocialActivitySet activitySet,
		ServiceContext serviceContext);

	public void updateActivitySet(long activityId) throws PortalException;

}