/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.subscription.util;

import com.liferay.portal.kernel.util.SubscriptionSender;

/**
 * @author Alejandro Tardín
 */
public interface UnsubscribeHelper {

	public void registerHooks(SubscriptionSender subscriptionSender);

}