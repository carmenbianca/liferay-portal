/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.vulcan.internal.jaxrs.validation;

import java.util.Collections;
import java.util.List;

import javax.validation.Validation;
import javax.validation.ValidationProviderResolver;
import javax.validation.Validator;
import javax.validation.spi.ValidationProvider;

import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

/**
 * @author Javier Gamarra
 */
public class ValidatorFactory {

	public static Validator getValidator() {
		HibernateValidatorConfiguration hibernateValidatorConfiguration =
			(HibernateValidatorConfiguration)Validation.byDefaultProvider(
			).providerResolver(
				new OSGiServiceDiscoverer()
			).configure();

		hibernateValidatorConfiguration.
			allowOverridingMethodAlterParameterConstraint(true);

		hibernateValidatorConfiguration.messageInterpolator(
			new ParameterMessageInterpolator());

		javax.validation.ValidatorFactory validatorFactory =
			hibernateValidatorConfiguration.buildValidatorFactory();

		return validatorFactory.getValidator();
	}

	private static class OSGiServiceDiscoverer
		implements ValidationProviderResolver {

		@Override
		public List<ValidationProvider<?>> getValidationProviders() {
			return Collections.singletonList(new HibernateValidator());
		}

	}

}