/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

import Soy from 'metal-soy';

import FormRenderer from '../../components/FormRenderer/FormRenderer.es';
import templates from '../../components/FormRenderer/FormRenderer.soy';
import withStore from '../../store/withStore.es';

const Form = withStore(FormRenderer);

Soy.register(Form, templates);

export default Form;
