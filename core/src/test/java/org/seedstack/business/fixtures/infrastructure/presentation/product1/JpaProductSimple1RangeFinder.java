/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.fixtures.infrastructure.presentation.product1;

import org.seedstack.business.api.interfaces.finder.Range;
import org.seedstack.business.api.interfaces.finder.Result;
import org.seedstack.business.fixtures.interfaces.product.presentationsimple1.ProductSimple1RangeFinder;
import org.seedstack.business.fixtures.interfaces.product.presentationsimple1.ProductSimple1Representation;

public class JpaProductSimple1RangeFinder implements ProductSimple1RangeFinder{

	@Override
	public Result<ProductSimple1Representation> find(Range range, String criteria) {
		return null;
	}
}
