/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.jenkins.results.parser.vm.amazon;

/**
 * @author Kiyoshi Lee
 */
public class CentOS7AmazonVM extends AmazonVM {

	protected CentOS7AmazonVM(
		String awsAccessKeyId, String awsSecretAccessKey, String instanceId) {

		super(awsAccessKeyId, awsSecretAccessKey, instanceId);
	}

	protected CentOS7AmazonVM(
		String awsAccessKeyId, String awsSecretAccessKey, String instanceType,
		String keyName) {

		super(
			awsAccessKeyId, awsSecretAccessKey, "ami-b1a59fd1", instanceType,
			keyName);
	}

	protected CentOS7AmazonVM(
		String awsAccessKeyId, String awsSecretAccessKey, String imageId,
		String instanceType, String keyName) {

		super(
			awsAccessKeyId, awsSecretAccessKey, imageId, instanceType, keyName);
	}

}