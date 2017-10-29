package pcb.uwu.units.composite.electromagnetism;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.composite.termodynamics.EnergyUnit;
import pcb.uwu.units.quantity.ElectricCurrentUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

public class MagneticFluxUnit extends CompositeUnit {

	// region base constructor

	public MagneticFluxUnit(MassUnit massUnit, LengthUnit lengthUnit, ElectricCurrentUnit electricCurrentUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(lengthUnit, 2)
				.minor(electricCurrentUnit)
				.minor(timeUnit, 2));
	}

	// endregion

	// region composite constructors

	public MagneticFluxUnit(ElectricPotentialUnit electricPotentialUnit, TimeUnit timeUnit) {
		super(new UnitCounter()
				.major(electricPotentialUnit.getUnitCounter())
				.major(timeUnit));
	}

	public MagneticFluxUnit(ElectricInductanceUnit electricInductanceUnit, ElectricCurrentUnit electricCurrentUnit) {
		super(new UnitCounter()
				.major(electricInductanceUnit.getUnitCounter())
				.major(electricCurrentUnit.getUnitCounter()));
	}

	public MagneticFluxUnit(MagneticFieldUnit magneticFieldUnit, LengthUnit lengthUnit) {
		super(new UnitCounter()
				.major(magneticFieldUnit.getUnitCounter())
				.major(lengthUnit, 2));
	}

	public MagneticFluxUnit(EnergyUnit energyUnit, ElectricCurrentUnit electricCurrentUnit) {
		super(new UnitCounter()
				.major(energyUnit.getUnitCounter())
				.minor(electricCurrentUnit.getUnitCounter()));
	}

	// endregion


}
