package pcb.uwu.unit.derived.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.ElectricCurrentUnit;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;

public class ElectricCapacitanceUnit extends CompositeUnit {

	// region base constructor

	public ElectricCapacitanceUnit(ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit, LengthUnit lengthUnit, MassUnit massUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit, 2)
				.major(timeUnit, 4)
				.minor(lengthUnit, 2)
				.minor(massUnit));
	}

	// endregion

	// region derived constructors

	public ElectricCapacitanceUnit(ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit, ElectricPotentialUnit electricPotentialUnit) {
		super(new UnitCounter()
				.major(electricCurrentUnit)
				.major(timeUnit)
				.minor(electricPotentialUnit.getUnitCounter()));
	}

	public ElectricCapacitanceUnit(ForceUnit forceUnit, LengthUnit lengthUnit, ElectricPotentialUnit electricPotentialUnit) {
		super(new UnitCounter()
				.major(forceUnit.getUnitCounter())
				.major(lengthUnit)
				.minor(electricPotentialUnit.getUnitCounter()));
	}

	public ElectricCapacitanceUnit(ElectricChargeUnit electricChargeUnit, ElectricPotentialUnit electricPotentialUnit) {
		super(new UnitCounter()
				.major(electricChargeUnit.getUnitCounter())
				.minor(electricPotentialUnit.getUnitCounter()));
	}

	public ElectricCapacitanceUnit(TimeUnit timeUnit, ElectricResistanceUnit electricResistanceUnit) {
		super(new UnitCounter()
				.major(timeUnit)
				.minor(electricResistanceUnit.getUnitCounter()));
	}

	// endregion
}
