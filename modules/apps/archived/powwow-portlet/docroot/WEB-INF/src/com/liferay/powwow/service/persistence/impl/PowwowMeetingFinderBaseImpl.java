/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.powwow.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.powwow.model.PowwowMeeting;
import com.liferay.powwow.service.persistence.PowwowMeetingPersistence;

/**
 * @author Shinn Lok
 * @generated
 */
public class PowwowMeetingFinderBaseImpl
	extends BasePersistenceImpl<PowwowMeeting> {

	public PowwowMeetingFinderBaseImpl() {
		setModelClass(PowwowMeeting.class);
	}

	/**
	 * Returns the powwow meeting persistence.
	 *
	 * @return the powwow meeting persistence
	 */
	public PowwowMeetingPersistence getPowwowMeetingPersistence() {
		return powwowMeetingPersistence;
	}

	/**
	 * Sets the powwow meeting persistence.
	 *
	 * @param powwowMeetingPersistence the powwow meeting persistence
	 */
	public void setPowwowMeetingPersistence(
		PowwowMeetingPersistence powwowMeetingPersistence) {

		this.powwowMeetingPersistence = powwowMeetingPersistence;
	}

	@BeanReference(type = PowwowMeetingPersistence.class)
	protected PowwowMeetingPersistence powwowMeetingPersistence;

}