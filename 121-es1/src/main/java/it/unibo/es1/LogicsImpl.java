package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

public class LogicsImpl implements Logics {
	private final List<Integer> values;

	public LogicsImpl(int size) {
		this.values = new ArrayList<>();
		for(int i = 0; i < size; i++){
			this.values.add(0);
		}
	}

	@Override
	public int size() {
		System.out.println(this.values.size());
		return this.values.size();
	}

	@Override
	public List<Integer> values() {
		return this.values;
	}

	@Override
	public List<Boolean> enablings() {
		return this.values.stream().map(i -> i != 4).toList();
	}

	@Override
	public int hit(int elem) {
		int newValue = this.values.get(elem);
		newValue++;
		this.values.set(elem, newValue);
		return newValue;
	}

	@Override
	public String result() {
		//<<0|2|1|3>>
		String result="<<";
		for(int i = 0; i < this.values.size() - 1; i++){
			result = result.concat(this.values.get(i).toString() + "|");
		}
		result = result.concat(this.values.getLast() + ">>");
		return result;
	}

	@Override
	public boolean toQuit() {
		return this.values.stream().allMatch(e -> e.equals(this.values.getFirst()));
	}
}
