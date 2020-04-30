/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.processor;

/**
 * Locates the available {@link AMAsyncProcessor}.
 *
 * @author Adolfo Pérez
 */
public interface AMAsyncProcessorLocator {

	public <M> AMAsyncProcessor<M, ?> locateForClass(Class<M> clazz);

}