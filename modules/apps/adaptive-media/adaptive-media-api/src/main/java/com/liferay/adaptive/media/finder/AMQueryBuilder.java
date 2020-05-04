/*
 * SPDX-FileCopyrightText: © 2017 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.adaptive.media.finder;

/**
 * A marker interface that implementations of {@link AMFinder} must extend to
 * provide a way to create {@link AMQuery} instances.
 *
 * @author Adolfo Pérez
 */
public interface AMQueryBuilder<M, T> {
}