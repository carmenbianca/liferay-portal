/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.scope;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Declares that a method on a JAX-RS resource does not need a scope to be
 * authorized. When used on a JAX-RS resource class, all methods without the
 * annotation inherit the resource class annotation.
 *
 * <p>
 * If scope annotation checking is enabled and a method has no {@link
 * RequiresScope} or {@code RequiresNoScope} annotation, the request isn't
 * authorized to execute that method as security precaution.
 * </p>
 *
 * @author Tomas Polesovsky
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresNoScope {
}